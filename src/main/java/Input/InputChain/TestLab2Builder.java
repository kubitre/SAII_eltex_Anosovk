package Input.InputChain;

public class TestLab2Builder extends Builder {
    public TestLab2Builder(){
        super(InputGroup.InputSteps.TESTLAb2);
    }
    @Override
    public void buildImpl(){
        System.out.print ( "There are will be teset module of laboratory work 2" );
    }

}
