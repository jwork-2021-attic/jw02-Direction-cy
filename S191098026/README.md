## 任务一 ##
1. example的类图

    ![](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/jwork-2021/jw02-Direction-cy/master/S191098026/uml/class1.plantuml)

    main方法执行过程中的对象时序图

    ![](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/jwork-2021/jw02-Direction-cy/master/S191098026/uml/timeline1.plantuml)

2. example设计了纯抽象可排列接口Linable，具有跟位置Position相关一些方法，可以完成跟Position的一一对应关系。

    Position是Line的一个内部类，与Line密切相关，每一个Position都应该放置一个可排列对象Linable，同时可以完成跟Linable的一一对应关系。

    葫芦娃Gourd具有可排列的属性，实现Linable接口, 有成员position完成一一对应。葫芦娃独有七个，所以是一个枚举类型，rgb确定颜色，rank为排序依据。

    Line理应有一系列位置，用于可排列对象排列，用put方法完成position和linable的对应。

    Sorter是一个排序器接口，有排序的相关方法

    BubbleSorter实现Sorter，通过序列值排序，是冒泡排序的具体实现，存储过程在plan中

    Geezer拥有一个排序器, 可设置想要的排序方法，lineup是按行排列，从line中提取linable对象，再提取rank值，排序器load进行排序，保存相应信息输出存储。

    main中line中put葫芦娃，theGeezer设置排序器，lineup进行行排列，写出log

    这样面向对象易于维护，由于继承的存在，即使需求改变，也只需要改变局部模块，比如，换一种可排序对象，换一种排序方式，继承sorter以及linable，很容易改变

    易扩展，由于继承、封装、多态的特性，此时排列方式是行，改动较少便可以将其改成矩阵排序

    可以重用代码，根据设计的需要对现实世界的事物进行抽象，开发效率高。

    面向对象是一种高内聚、低耦合的系统结构。

    改进之处，我感觉position和linable既然互相绑定是否可以化简一下；position作为内部类可能不是很符合特性吧；代码低耦合和复杂度是否可以折中一下，感觉稍显冗余,这也带来了一个问题在Geezer中execute方法中，他明确地知道自己在排序葫芦娃。

## 任务二 ##
1. 类图如下

    ![](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/jwork-2021/jw02-Direction-cy/master/S191098026/uml/class2.plantuml)

2. 可视化结果如下，采用归并排序

    [![asciicast](https://asciinema.org/a/90CYw7A2jayfaypKEett5KKty.svg)](https://asciinema.org/a/90CYw7A2jayfaypKEett5KKty)


## 任务三 ##
1. 类图如下

    ![](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/jwork-2021/jw02-Direction-cy/master/S191098026/uml/class3.plantuml)

2. 可视化结果如下，采用归并排序

    [![asciicast](https://asciinema.org/a/4kZR4oSKQJ6icqlmMdqpL4IYM.svg)](https://asciinema.org/a/4kZR4oSKQJ6icqlmMdqpL4IYM)