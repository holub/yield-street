package yieldstreet.test.names;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class UniqueNames {

    LinkedHashSet<String> observedOnce = Sets.newLinkedHashSet();
    Set<String> multipleObserved = Sets.newHashSet();

    public void addName(@NotNull String name) {
        Preconditions.checkNotNull(name);

        if(!multipleObserved.contains(name)) {
            boolean alreadyObserved = observedOnce.remove(name);
            if(alreadyObserved) {
                multipleObserved.add(name);
            } else {
                observedOnce.add(name);
            }
        }
    }

    public void addNames(String... names) {
        for(String name : names) {
            addName(name);
        }
    }

    public Optional<String> findUniqueFirst() {
        return Optional.ofNullable(
                Iterables.getFirst(observedOnce, null)
        );
    }
}
