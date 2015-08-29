package io;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {

	
	InputStream _in;
	int _inByte;
	int _inCount;
	static boolean _opened = false;
	
	public MyDecompressorInputStream(InputStream in) {
		super();
		_in = in;
		_inCount = 0;
	}


	@Override
	public int read() throws IOException {
		
		if (!_opened)
		{
		//	System.out.println("Now Open");
			_inByte =_in.read();
			_inCount=_in.read();
		//	System.out.print("NewChar " +_inByte);
		//	System.out.println(" Times " +_inCount);
			_inCount--;
			_opened = true;
			return (int) _inByte;
		}
		else
		{
		if (_inCount > 0)
			{

				_inCount--;
				return _inByte;
			}
		else
			{
				_inByte=(byte) _in.read();
	//			System.out.print("NewChar " +_inByte);
				_inCount=(byte) _in.read();
		//		System.out.println(" Times " +_inCount);
				_inCount--;
				return (int) _inByte;
			}
		}
	
	}

}
