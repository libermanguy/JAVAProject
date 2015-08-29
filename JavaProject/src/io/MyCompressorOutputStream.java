package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {

	OutputStream _out;
	int _outByte;
	int _outCount;
	static boolean _opened = false;
	
	public MyCompressorOutputStream(OutputStream out) {
		super();
		this._out = out;
	}


	@Override
	public void write(int b) throws IOException {
		if (!_opened)
		{
			_outByte = b;
			_outCount = 1;
			_opened = true;
		}
		else
		{
			if (b == _outByte)
				_outCount++;
			else
				{
			//		System.out.print("Char out " + _outByte);
					_out.write(_outByte);
			//		System.out.println(" Number out " + _outCount);
					_out.write(_outCount);
					_outByte=b;
					_outCount=1;
				}
		}

	}
	
	@Override
	public void close() throws IOException {
//		System.out.print("Char out " + _outByte);
		_out.write(_outByte);
	//	System.out.println(" Number out " + _outCount);
		_out.write(_outCount);
		super.close();
	}

}
