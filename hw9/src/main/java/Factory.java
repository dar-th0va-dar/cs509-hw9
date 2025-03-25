public class Factory {
    public enum Animal {
        DOG,
        CAT
    }

    public interface IAnimal {
        void speak();
    }

    static class Dog implements IAnimal {

        @Override
        public void speak() {
            System.out.println("woof");
        }
    }

    static class Cat implements IAnimal {

        @Override
        public void speak() {
            System.out.println("meow");
        }
    }

    static public class AnimalFactory {
        public static IAnimal create(Animal animal) {
            if (animal == Animal.DOG) {
                return new Dog();
            } else if (animal == Animal.CAT) {
                return new Cat();
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        IAnimal dog = AnimalFactory.create(Animal.DOG);
        IAnimal cat = AnimalFactory.create(Animal.CAT);

        dog.speak();
        cat.speak();
    }
}
