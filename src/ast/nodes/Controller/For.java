package ast.nodes.Controller;

//for(x = 1 : 5 , -5)[
public class For extends ControllerBody {
    private String iteratorName;
    private int initialStep;
    private int finalStep;
    private int step;
    private NestedCode nestedCode;

    public String getIteratorName() {
        return iteratorName;
    }

    public void setIteratorName(String iteratorName) {
        this.iteratorName = iteratorName;
    }

    public int getInitialStep() {
        return initialStep;
    }

    public void setInitialStep(int initialStep) {
        this.initialStep = initialStep;
    }

    public int getFinalStep() {
        return finalStep;
    }

    public void setFinalStep(int finalStep) {
        this.finalStep = finalStep;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public NestedCode getNestedCode() {
        return nestedCode;
    }

    public void setNestedCode(NestedCode nestedCode) {
        this.nestedCode = nestedCode;
    }

    @Override
    public String toString() {
        return "For{" +
                "iteratorName='" + iteratorName + '\'' +
                ", initialStep=" + initialStep +
                ", finalStep=" + finalStep +
                ", step=" + step +
                ", nestedCode=" + nestedCode +
                '}' + '\n';
    }

    @Override
    public String codeGenerate() {
        return "for(" + "$" + iteratorName + "=" + initialStep + ";"
                + "$" + iteratorName + "<=" + finalStep + ";"
                + "$" + iteratorName + "+=" + step + ")\n"
                +"{\n" + nestedCode.codeGenerate() + "\n}";
    }
}
