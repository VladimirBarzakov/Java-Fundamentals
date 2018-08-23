package p01_system_resources;

public class WriterImpl implements Writer {
    @Override
    public void println(String line) {
        System.out.println(line);
    }
}
