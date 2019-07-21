package wzcroad;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.NoSuchElementException;

public class TestMergeRemoteIterator {
    class MockIterator<T> implements RemoteIterator<T> {
        T[] array;
        int index = 0;

        public MockIterator(T[] array) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            if(index < array.length && array[index] != null)
                return true;
            return false;
        }

        @Override
        public T next() {
            if(hasNext())
                return array[index++];
            else
                return null;
        }
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void test() throws IOException {
        exception.expect(NoSuchElementException.class);
        Integer[] a1 = {1};
        Integer[] a2 = {};
        Integer[] a3 = {3};

        RemoteIterator<Integer> remoteIt1 = new MockIterator<Integer>(a1);
        RemoteIterator<Integer> remoteIt2 = new MockIterator<Integer>(a2);
        RemoteIterator<Integer> remoteIt3 = new MockIterator<Integer>(a3);

        RemoteIterator[] rIt = {remoteIt1};
        MergeRemoteIterator<Integer> merge = new MergeRemoteIterator<Integer>(rIt);
        System.out.println(merge.hasNext());
        System.out.println(merge.next());
        System.out.println(merge.hasNext());
        System.out.println(merge.next());
    }
}
