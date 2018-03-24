package Input.InputChain;

import java.util.*;

public class InputGroup {
    private final Set stepsInput = new HashSet (  );
    private final String[] Params = new String[]{};
    public InputGroup (String[] paramss,InputSteps... steps) {
        this.stepsInput.addAll ( Arrays.asList ( steps ) );

        for(int i = 0; i< paramss.length; i++){
            this.Params[i] = paramss[i];
        }
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

