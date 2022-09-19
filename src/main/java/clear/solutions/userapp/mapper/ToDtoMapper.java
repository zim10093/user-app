package clear.solutions.userapp.mapper;

public interface ToDtoMapper<D, M> {
    D toDto(M model);
}
