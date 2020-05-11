package two.five;

abstract class Factory<T> {
    public Factory() {
        Class aClass = this.getClass();

       // aClass.getDeclaredConstructor().newInstance()
    }
    public T generateInstance() throws Exception {

        return null;
    }
}