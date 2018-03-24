package Input.InputChain;

public abstract class Builder
{
    protected Builder nextBuilder;
    private final InputGroup.InputSteps step;

    public Builder(InputGroup.InputSteps step){
        this.step = step;
    }

    public abstract void buildImpl(String[] Params);

    public void build(InputGroup input, String[] param){
        if(input.getSteps ().contains ( step )){
            buildImpl (param);

        }
        if(nextBuilder != null){
            nextBuilder.build (input, param);
        }
    }

    public Builder setNext(Builder builder){
        this.nextBuilder = builder;
        return builder;
    }
}
