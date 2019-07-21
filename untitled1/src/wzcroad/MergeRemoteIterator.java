package wzcroad;

import java.util.NoSuchElementException;

class MergeRemoteIterator<T> implements RemoteIterator<T> {
    int index = 0;
    RemoteIterator[] Iterator;

    public MergeRemoteIterator(RemoteIterator[] Iterator) {
        this.Iterator = Iterator;
    }

    public boolean hasNext() {
        if(index + 1 > Iterator.length)
            return false;
        boolean flag = Iterator[index].hasNext();
        if(!flag) {
            index++;
            return hasNext();
        } else
            return true;
    }

    public T next() {
        if(hasNext())
            return (T) Iterator[index].next();
        else {
            throw new NoSuchElementException();
        }
    }
}
