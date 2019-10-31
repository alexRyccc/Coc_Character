package Reflect;

/**
 * @author ran_ych
 * @create 2019-10-23  11:42
 * @desc
 */
public class DemoBean {
    public String pubField;
    protected String protectField;
    String defaultField;
    @AnnotationDemo(name="test",value="123")
    private String priField;

    public DemoBean(){
        this("pub","protect","default","pri");
    }
    public DemoBean(String pubField,String protectField,String defaultField,String priField){
        this.pubField = pubField;
        this.protectField = protectField;
        this.defaultField = defaultField;
        this.priField = priField;
    }
    public void function1(){
        System.out.println("public function");
    }
    protected void function2(){
        System.out.println("protect function");
    }
    void function3(){
        System.out.println("default function");
    }
    private void function4(){
        System.out.println("private function");
    }
}
