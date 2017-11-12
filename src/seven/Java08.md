# 1. 本周学习总结

以你喜欢的方式（思维导图或其他）归纳总结集合相关内容。

# 2. 书面作业

## 1. ArrayList代码分析

1.1 解释ArrayList的`contains`源代码

```java
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }
```
源代码里就一句，即寻找传入对象的序号，看是不是大于0，大于0就表示存在。

1.2 解释`E remove(int index)`源代码

在List类中是个抽象方法，留给子类去实现。在ArrayList中代码如下

```java
    public E remove(int index) {
        rangeCheck(index);//先进行范围检查，若传入的是一个超范围的序号，就抛出数组越界错误

        modCount++;
        E oldValue = elementData(index);//保存旧的值

        int numMoved = size - index - 1;//计算移除元素后的长度
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);//将原来的数组缩小，将要移除的值移动到最后一个
        elementData[--size] = null; // clear to let GC do its work
        // 将最后一个变为null，交给垃圾回收系统处理
        
        return oldValue;
    }
```

1.3 结合1.1与1.2，回答ArrayList存储数据时需要考虑元素的具体类型吗？

不需要，所用的数据类型都是Object，当建立的是一个Object的ArrayList的时候，可以放入任何类型的元素

1.4 分析add源代码，回答当内部数组容量不够时，怎么办？

```java
    public boolean add(E e) {
            ensureCapacityInternal(size + 1);  // Increments modCount!!翻译过来就是上升数组容量
            elementData[size++] = e;
            return true;
    }
    private void ensureCapacityInternal(int minCapacity) {
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {//空数组情况
                minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
            }
    
            ensureExplicitCapacity(minCapacity);
    }
    private void ensureExplicitCapacity(int minCapacity) {
            modCount++;
    
            // overflow-conscious code
            if (minCapacity - elementData.length > 0)//如果数组的长度比需求的长度小
                grow(minCapacity);
    }
    private void grow(int minCapacity) {//数组扩容
            // overflow-conscious code
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0)
                newCapacity = minCapacity;
            if (newCapacity - MAX_ARRAY_SIZE > 0)
                newCapacity = hugeCapacity(minCapacity);
            // minCapacity is usually close to size, so this is a win:
            elementData = Arrays.copyOf(elementData, newCapacity);
    }
```
超出容量后，新的数组大小会变成原来数组大小加这个数字的右移1位（居然位运算，原长4就加2，原长3就加1之类的）
然后生成新的数组，将原来的数据填充进新的数组

1.5 分析`private void rangeCheck(int index)`源代码，为什么该方法应该声明为private而不声明为public?

我也有点疑惑，但是源码注释里写了，这个方法完全信任传入的index，即必需将数组的length传入，如果暴露出来可能会被开发者滥用吧。（个人观点）

## 2. HashSet原理

2.1 将元素加入HashSet(散列集)中，其存储位置如何确定?需要调用那些方法？

`hashcode`算出将插入的位置，若位置上已存在元素，用`equals`判断是否相同，相同就返回，整个过程结束，不相同就调用add方法添加

2.2 将元素加入HashSet中的时间复杂度是多少？是O(n)吗？(n为HashSet中已有元素个数)

时间复杂度是O(1)

2.3 选做：尝试分析HashSet源代码后，重新解释2.1

可以从以下源码看出，HashSet的contains方法是先计算要比较对象的hash值，然后从第一个开始，循环判断每一个元素的hash以及使用equals方法对比

另：计算hash的方法是使用hashCode计算出值再按位异或这个值无符号右移16位

```java
    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
    
    static final int hash(Object key) {
            int h;
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
```

## 3. ArrayListIntegerStack

题集`jmu-Java-05-集合`之ArrayListIntegerStack

3.1 比较自己写的ArrayListIntegerStack与自己在题集`jmu-Java-04-面向对象2-进阶-多态、接口与内部类`中的题目`自定义接口ArrayIntegerStack`，有什么不同？(不要出现大段代码)

`自定义接口ArrayIntegerStack`是一个接口，且那道题中是使用数组实现那个接口，ArrayListIntegerStack内部是使用ArrayList实现的，这是最大的不同

3.2 结合该题简单描述接口的好处，需以3.1为例详细说明，不可泛泛而谈。

## 4. Stack and Queue

4.1 编写函数判断一个给定字符串是否是回文，一定要使用栈(请利用Java集合中已有的类)，但不能使用java的`Stack`类（具体原因自己搜索）与数组。请粘贴你的代码，类名为`Main你的学号`。

```java
public class Main201621123029 {

    private LinkedList storeList;
    public Main201621123029(String in) {
        storeList = new LinkedList();
        for (int i = 0; i < in.length(); i++) storeList.push(in.charAt(i));
    }
    Main201621123029 pop(Consumer consumer) {
        if (storeList.size() < 1) return this;
        consumer.accept(storeList.pop());
        return this;
    }
    public static void main(String[] args) {
        String left = args[1];
        String right = left;
        Main201621123029 tt = new Main201621123029(left);
        final int[] sum = {0};
        for (char e : right.toCharArray())
            tt.pop(each -> {
                if (each.equals(e)) sum[0]++;
            });
        if (sum[0]==right.length()) System.out.println("回文");
    }
}
```

4.2 题集`jmu-Java-05-集合`之银行业务队列简单模拟(只粘贴关键代码)。请务必使用`Queue`接口，并说明你使用了Queue接口的哪一个实现类？

使用了`ArrayDeque`，关键部分：

```java
        for (int i = 0; i < length; i++) {
            if (odd.isEmpty()) System.out.print(even.poll());
            else if (even.isEmpty()) System.out.print(odd.poll());
            else {
                switch (i % 3) {
                    case 0:
                        System.out.print(odd.poll());
                        break;
                    case 1:
                        System.out.print(odd.poll());
                        break;
                    case 2:
                        System.out.print(even.poll());
                        break;
                }
            }
            if (i!=length-1) System.out.print(' ');
        }
```

## 5. 统计文字中的单词数量并按单词的字母顺序排序后输出

题集`jmu-Java-05-集合`之5-2 统计文字中的单词数量并按单词的字母顺序排序后输出 (作业中不要出现大段代码)

代码挺少的，就全放上来。

```java
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeSet<String> rec = new TreeSet<>();
        String st;
        while (!(st = in.next()).equals("!!!!!")) {
            rec.add(st);
        }
        System.out.println(rec.size());
        Iterator iterator = rec.iterator();
        for (int i = 0; i < rec.size(); i++) {
            if (i<10) System.out.println(iterator.next());
        }
    }

}
```

5.1 实验总结

TreeSet按照单个字母排序，HashSet按照整体字母排序，这点值得注意。
高级数据结构，Set，Map，不能使用随机读取，也没有get或者indexOf，只能使用迭代器遍历

# 3.码云及PTA

题目集：`jmu-Java-05-集合`

## 3.1. 码云代码提交记录

- 在码云的项目中，依次选择“统计-Commits历史-设置时间段”, 然后搜索并截图

## 3.2 截图PTA题集完成情况图

需要有两张图（1. 排名图。2.PTA提交列表图）

## 3.3 统计本周完成的代码量

需要将每周的代码统计情况融合到一张表中。