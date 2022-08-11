package son.peace.core

interface BaseMapper<T, F> {
    fun map(from: T): F
}