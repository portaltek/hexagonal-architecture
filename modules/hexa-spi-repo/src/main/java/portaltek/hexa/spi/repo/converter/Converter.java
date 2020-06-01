package portaltek.hexa.spi.repo.converter;

interface Converter<I, O> {

    O from(I input);
}
