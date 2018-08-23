package p10to14Inferno.engine;

import p10to14Inferno.IO.InputReader;
import p10to14Inferno.IO.OutputWriter;
import p10to14Inferno.controller.Controller;
import p10to14Inferno.factories.GemFactory;
import p10to14Inferno.factories.WeaponFactory;
import p10to14Inferno.repositories.WeaponRepository;

public class Engine {
    private WeaponFactory weaponFactory;
    private GemFactory gemFactory;
    private WeaponRepository weaponRepository;
    private InputReader reader;
    private OutputWriter writer;
    private Controller controller;


    public Engine() {
        this.weaponFactory = new WeaponFactory();
        this.gemFactory = new GemFactory();
        this.reader=new InputReader();
        this.writer=new OutputWriter();
        this.weaponRepository=new WeaponRepository();
        this.controller = new Controller(
                this.weaponRepository,
                this.weaponFactory,
                this.gemFactory);
    }

    public void run(){
        String line;
        while (true){
            line=reader.readLine();
            if ("END".equals(line)){
                this.reader.close();
                this.writer.close();
                break;
            }
            String result = this.controller.executeCommand(line);
            if (result!=null){
                this.writer.writeLine(result);
            }

        }
    }
}
