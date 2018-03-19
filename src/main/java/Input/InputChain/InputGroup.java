package Input.InputChain;

import java.util.*;

public class InputGroup {
    private final Set stepsInput = new HashSet (  );

    public InputGroup (InputSteps... steps) {
        this.stepsInput.addAll ( Arrays.asList ( steps ) );
    }

    enum InputSteps{
        TESTLAb1,
        TESTLAb2,
        TESTLAb3,
        TESTLAb4,
        TESTLAb5,
        TESTLAb6,
        TESTLAb7,
        TESTLAb8,
        VIEWALL,
    }

    public Set getSteps(){
        return this.stepsInput;
    }
}

