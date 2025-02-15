import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//menggunakan generics dan collections
public class WarriorList<T extends Warrior> {
    private List<Warrior> warriors = new ArrayList<Warrior>(); // meginstansiasi dengan concrete class yang merupakan List
    private Queue<Warrior> fallenWarriors = new LinkedList<Warrior>(); // menginstansiasi dengan concrete class yang merupakan Queue

    //menambahkan warrior ke list warriors
    public void addWarrior(Warrior warrior) {
        warriors.add(warrior);
    }
    //method untuk remove warrior dari list warriors
    public void removeWarrior(Warrior warrior) {
        warriors.remove(warrior);
    }
    //method untuk remove fallenwarriors dari list fallenwarriors dan menambahkannya ke warriors
    public void removeFallenWarrior (Warrior warrior){
        fallenWarriors.remove(warrior);
        warriors.add(warrior);
    }
    //method getter list warriors
    public List<Warrior> getWarriors() {
        return warriors;
    }
    //method untuk menambahkan warrior ke fallenwarriors
    public void addFallenWarrior(Warrior warrior) {
        // TODO
        fallenWarriors.add(warrior);
    }
    //method untuk mengambil queueu fallenwarriors
    public Queue<Warrior> getFallenWarriors() {
        return fallenWarriors;
    }
}
