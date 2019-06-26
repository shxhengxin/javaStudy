package xin.shenheng.demo07;

public class Hero {
    private String name;
    private SKill sKill;//技能

    public Hero() {
    }

    public Hero(String name, SKill sKill) {
        this.name = name;
        this.sKill = sKill;
    }

    public void attack() {
        System.out.println("我叫" + name + ",技能是:" );
        sKill.use();
        System.out.println("完毕");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SKill getsKill() {
        return sKill;
    }

    public void setsKill(SKill sKill) {
        this.sKill = sKill;
    }
}
