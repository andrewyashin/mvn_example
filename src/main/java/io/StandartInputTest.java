package io;

import javax.management.ReflectionException;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by andrew_yashin on 1/30/17.
 */
public class StandartInputTest {

    public static void main(String... args) {

        InputStream console = System.in;
        PrintStream print = System.out;

        try {
            BufferedInputStream in = new BufferedInputStream(
                    new FileInputStream("/Users/andrew_yashin/Desktop/Shape.java"));

            System.setIn(in);

            BufferedReader inBuff = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while ((s = inBuff.readLine()) != null) {
                System.out.println(s);
            }

            in.close();
            System.setIn(console);
            inBuff.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(System.getProperty("file.encoding"));

        ByteBuffer bb = ByteBuffer.allocate(1024);
        bb.asShortBuffer().put((short) 123);
        bb.asIntBuffer().put((int) 345);
        bb.asLongBuffer().put((long) 234);
        bb.asFloatBuffer().put((float) 45.12312);


        System.out.println(bb.getFloat());

        ByteBuffer bb1 = ByteBuffer.allocate(1024);
        DoubleBuffer db = bb1.asDoubleBuffer();
        System.out.println(db);
        db.put(new double[]{0.44, 34, 45.6, 46});

        System.out.println(db.get(3));

        System.out.println(bb1.array().length);
        System.out.println(bb1.order(ByteOrder.LITTLE_ENDIAN));
        System.out.println(bb1.getDouble());

        try {
            MappedByteBuffer bb3 = new RandomAccessFile("test.txt", "rw").getChannel()
                    .map(FileChannel.MapMode.READ_WRITE, 0, 0x8FFFFFF);


        } catch (IOException e){
            e.printStackTrace();
        }

        try {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("testZIP.zip"));
            BufferedOutputStream out = new BufferedOutputStream(zos);

            File path = new File("/Users/andrew_yashin/Desktop/");
            File[] filesJAVA = path.listFiles(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(".*\\.java");

                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });

            for(File file: filesJAVA){
                System.out.println(file.getName());
                zos.putNextEntry(new ZipEntry(file.getName()));
            }

            zos.close();
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        try {
            ObjectInputStream in3 = new ObjectInputStream(
                    new FileInputStream("test.out"));




            in3.close();

        } catch (IOException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            ObjectOutputStream outStream = new ObjectOutputStream(
                    new FileOutputStream("test3.dat")
            );

            TryExternalizible obj = new TryExternalizible(2, "Hi hi");
            outStream.writeObject(obj);

            ObjectInputStream inStream = new ObjectInputStream(
                    new FileInputStream("test3.dat")
            );

            System.out.println(inStream.readObject());
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }


    public static class TryExternalizible implements Externalizable{
        private int i;
        private String s;

        TryExternalizible(){
            System.out.println("default");
        }

        public TryExternalizible(int i, String s) {
            this.i = i;
            this.s = s;
        }

        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(i);
        }

        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            in.readInt();
        }

        @Override
        public String toString() {
            return this.i + " = " + this.s;
        }
    }

}
