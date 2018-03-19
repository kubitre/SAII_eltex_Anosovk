package Input.InputChain;

public class TestLab1Builder extends Builder {
    public TestLab1Builder(){
        super(InputGroup.InputSteps.TESTLAb1);
    }
    @Override
    public void buildImpl(){
        System.out.print ( "There are will be teset module of laboratory work 1" );
    }

}
