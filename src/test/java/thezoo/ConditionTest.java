package thezoo;

import org.junit.Assert;
import org.junit.Test;
import thezoo.implementation.СonditionImpl;
import thezoo.model.Condition;
import thezoo.model.Species;

import java.util.List;

import static org.junit.Assert.*;

public class ConditionTest {

    @Test
    public void isAvailableFor() {
        Condition condition = new СonditionImpl(Species.LEON);

        List<Species> conditionList = condition.isAvailableFor();

        Assert.assertEquals(conditionList.get(0), Species.LEON);
    }
}