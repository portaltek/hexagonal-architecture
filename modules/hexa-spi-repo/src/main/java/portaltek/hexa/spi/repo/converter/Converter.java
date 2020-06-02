package portaltek.hexa.spi.repo.converter;

import java.util.List;
import java.util.stream.Collectors;

interface Converter<I, O> {

    O from(I input);

    default List<O> from(final List<I> input) {
        return input.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }
}
