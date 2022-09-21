package clear.solutions.userapp.mapper;

public interface ToModelMapper<D, M> {
    M toModel(D dto);
}
