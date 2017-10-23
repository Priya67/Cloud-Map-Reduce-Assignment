# Cloud-Map-Reduce-Assignment

In this assignment, you are asked to identify three-page link triples (shown in the following
figure) from a set of given link pairs using MapReduce.

1 -> 2 -> 3

For simplicity, you can simply generate the following output:

<“3, 2”, 1 >

Webpages 3 and 2 are concatenated into a single value. If there are multiple webpages
having links to page 2, which further has links to page 3, the output should be:

<“3, 2”,“1, 4, 5, 6, 7”>

Note that pages 1, 4, 5, 6, 7 are also concatenated into a single value. Note that all pages
in a three-page link triple need to be DISTINCT! For example, triples corresponding to the
following examples, i.e., <“3, 2”, 2 > or <“1, 1”, 1 >, should not be included in the output.

For simplicity, integers are used to denote URLs, each distinct integer corresponds to a
URL. Sample input and output are given as follows.
Sample Input:

1 2

1 3

1 4

2 3

2 4

3 4

2 1


Sample Output:
3,1 2

4,1 2

3,2 1

4,2 1

4,3 2,1
