package uebung_16_5;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

public class Exercise {
	public static void main(String[] args) {
		String SP;
		SP = System.lineSeparator();
		Path p = Paths.get(System.getProperty("user.dir") + File.separator + "FileIO" + File.separator + "uebung_16_5"
				+ File.separator + "alphabet.txt");
		String str = SP + "*** Das Umgekehrte Alphabet ***" + SP;

		try (FileChannel fc = FileChannel.open(p, READ, WRITE)) {

			ByteBuffer dst = ByteBuffer.allocate((int) fc.size());

			fc.position(fc.read(dst, 0));
			long dstSize = fc.position();

			fc.write(ByteBuffer.wrap(str.getBytes()));

			dst.rewind();
			byte tmp;

			for (int max = (int) dstSize / 2, iter = 0; max > 0; max--, iter++) {
				tmp = dst.get(iter);
				dst.put(iter, dst.get((int) dstSize - iter - 1));
				dst.put((int) dstSize - iter - 1, tmp);
			}

			dst.rewind();
			fc.write(dst);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}