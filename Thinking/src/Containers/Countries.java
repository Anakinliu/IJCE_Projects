package Containers;

import java.util.*;

/*
    AUTHOR: linux
    TIME: 2018/5/7
    GOOD LUCK AND NO BUG.
*/
public class Countries {
    public static final String[][] DATA = {
            // Africa
            {"ALGERIA", "Algiers"}, {"ANGOLA", "Luanda"},

            // Asia
            {"CHINA", "Beijing"},

            // Australia and Oceania
            {"Australia", "Canberra"}, {"FUJI", "Suva"},


            // Eastern Europe and former USSR
            {"ARMENIA", "Yerevan"}, {"GEORGIA", "Tbilisi"},

            // Europe
            {"ALBANIA", "TirANA"}, {"ANDORRA", "Andorra la Vella"},


            // North and Central America
            {"US", "Washington, D.C."}, {"CUBA", "Havana"},

            // South America
            {"ARGENTINA", "Buenos Aires"}, {"BRAZIL", "Sucre"}
    };


    // Use AbstractMap by implements entrySet
    private static class FlyweightMap extends AbstractMap<String, String> {

        // 定制的Entry, 只存储了索引
        private static class Entry implements Map.Entry<String, String> {
            // 只存储了索引, 不是实际的建和值
            int index;

            public Entry(int index) {
                this.index = index;
            }

            @Override
            public String getKey() {
                return DATA[index][0];
            }

            @Override
            public String getValue() {
                return DATA[index][1];
            }

            // 设置throw Exception后就不用管是否有返回值了
            @Override
            public String setValue(String value) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean equals(Object obj) {
                return DATA[index][0].equals(obj);
            }

            @Override
            public int hashCode() {
                return DATA[index][0].hashCode();
            }
        }

        // use Abstract by implements size() & iterator()
        // 定制的set
        static class EntrySet extends AbstractSet<Map.Entry<String, String>> {

            private int size;

            public EntrySet(int size) {
                if (size < 0) {
                    this.size = 0;
                } else if (size > DATA.length) {
                    this.size = DATA.length;
                } else {
                    this.size = size;
                }

            }

            //-------------
            private class Iter implements Iterator<Map.Entry<String, String>> {
                // Only one Entry object per Iterator
                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index < size - 1;
                }

                @Override
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }

            @Override
            public Iterator<Map.Entry<String, String>> iterator() {
                return new Iter();
            }

            @Override
            public int size() {
                return size;
            }
        }

        //-----------
        private static Set<Map.Entry<String, String>> entries =
                new EntrySet(DATA.length);

        public Set<Map.Entry<String, String>> entrySet() {
            return entries;
        }

    }

    // Create a partial map of 'size' countries 方法可以加上final防止修改
    static Map<String, String> select(final int size) {
        return new FlyweightMap() {
            @Override
            public Set<Map.Entry<String, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }

    static Map<String, String> map = new FlyweightMap();

    public static Map<String, String> capitals() {
        return map;
    }

    public static Map<String, String> capitals(int size) {
        return select(size);
    }

    static List<String> names = new ArrayList<>(map.keySet());

    public static List<String> names() {
        return names;
    }

    public static List<String> names(int size) {
        return new ArrayList<>(select(size).keySet());
    }

    public static void main(String[] args) {
        System.out.println(capitals(10));
        System.out.println(names(10));
        System.out.println(new HashMap<>(capitals(100)));
        System.out.println(new TreeMap<>(capitals(100)));

    }
}

