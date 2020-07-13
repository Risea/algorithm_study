package cn.seands.algorithm.search;

/**
 * 二分查找
 */
public class BinarySearch {

    /**
     * 循环 二分查找
     * @param key   待查找的值
     * @param arr   有序 数组
     * @return
     */
    public static int binarySearch(int key, int[] arr){
        int left = 0;
        int right = arr.length-1;
        int idx;
        // 搜索区间 [left, right]   --> 初始: [0, len(arr)-1]
        // 迭代一次--> [0, mid-1]    or    [mid+1, len(arr)-1]
        // ... 如此例搜索区间为[1, 3, 5]  --> [3]  --> return 1
        while(left <= right) {
            // 中间值
            //idx = (right + left) / 2;         如第二次搜索区间在右边，int类型相加可能溢出 超出Integer.MAX
            idx = left + (right - left) / 2;
            if(key == arr[idx]){
                return idx;
            }else if (key < arr[idx]) {
                // key 比中间值还小、去左边找
                right = idx-1;
            } else if (key > arr[idx]) {
                // key 比中间值还大、去右边找
                left = idx+1;
            }
        }
        return -1;
    }


    /**
     * 循环 二分查找
     * @param key   待查找的值
     * @param arr   有序 数组
     * @return
     */
    public static int binarySearch2(int key, int[] arr){
        int left = 0;
        int right = arr.length;
        int idx;
        // 搜索区间 初始: [0, len(arr)-1)  ->  [0, mid), [mid, right)  -> left=right, break
        while(left < right) {
            // 中间值
            idx = left + (right - left) / 2;
            if(key == arr[idx]){
                return idx;
            }else if (key < arr[idx]) {
                // key 比中间值还小、去左边找
                right = idx;
            } else if (key > arr[idx]) {
                // key 比中间值还大、去右边找
                left = idx+1;
            }
        }
        return arr[left] == key ? left : -1;
    }

    /**
     * 递归 二分查找
     * @param key   待查找的值
     * @param arr   有序 数组
     * @param left  初始一般默认 0
     * @param right 初始一般默认 arr.length - 1
     * @return
     */
    public static int binarySearch3(int key, int[] arr, int left, int right){
        // 退出条件
        if(left > right){
            return -1;
        }
        int mid = left + (right - left)/2;
        if(key < arr[mid]){     // 左边找
            return binarySearch3(key, arr, left, mid-1);
        }else if(key > arr[mid]){   // 右边找
            return binarySearch3(key, arr, mid+1, right);
        }else{
            return mid;
        }
    }


    public static int binarySearchByLeft(int key, int[] arr){
        int left = 0;
        int right = arr.length - 1;
        int mid;
        // [0, len(arr)-1]   -> [0, mid-1] / [mid+1, len(arr)-1]
        while (left <= right){
            mid = left + (right-left)/2;
            if(key <= arr[mid]){
                // 等于 也往左侧收敛继续查找
                // 最小一次 left = right = 0  --> left = 0, right = -1
                right = mid - 1;
            }else{
                // 一直往右没找到 可能超过len(arr)-1
                // 最大一次 left = right = len-1 --> left = len, right = len-1
                left = mid + 1;
            }
        }
        // left最后范围: [0, len]
        if(left <= arr.length-1 && arr[left] == key){
            return left;
        }
        return -1;
    }

    public static int binarySearchByRight(int key, int[] arr){
        int left = 0;
        int right = arr.length - 1;
        int mid;
        // [0, len(arr)-1]   -> [0, mid-1] / [mid+1, len(arr)-1]
        while (left <= right){
            mid = left + (right-left)/2;
            if(key >= arr[mid]){
                // 等于的时候 向右收敛  一直往右没找到 可能超过len(arr)-1
                // 最大一次 left = right = len-1 --> left = len, right = len-1
                left = mid + 1;
            }else{
                // 最小一次 left = right = 0  --> left = 0, right = -1
                right = mid - 1;
            }
        }
        // right最后范围: [-1, len-1]
        if(right >= 0 && arr[right] == key){
            return right;
        }
        return -1;
    }

    /**
     * 二分查找，有限返回左侧匹配上的
     * @param key
     * @param arr
     * @return
     */
    public static int binarySearchByLeft2(int key, int[] arr){
        if (arr.length == 0){
            return -1;
        }
        int left = 0;
        int right = arr.length;
        // [1, 2, 3, 3, 3, 3, 3, 5]             [left, right)
        // -> [1, 2, 3, 3]                      左: [left, mid) ,  右:[mid+1, right)
        // -> [1, 2]
        // -> [3]
        while (left < right){           // 最后终止条件是left == right
            int mid = left + (right-left)/2;
            // 如果 待搜索值 <= 中间值   在左侧搜 [0, mid]  一直收敛到 left == right
            if(key <= arr[mid]){
                right = mid;
            // 如果 key 大于中间值 则右边搜索 [mid, len(arr)-1]
            }else if(key > arr[mid]){
                left = mid+1;
            }
        }
        // left 一直右区间搜索到最右边   即key > arr中所有的数
        if (left == arr.length) return -1;
        // 中间未找到 返回-1
        return key == arr[left] ? left : -1;
    }


    /**
     * 二分查找，有限返回左侧匹配上的
     * @param key
     * @param arr
     * @return
     */
    public static int binarySearchByRight2(int key, int[] arr){
        if (arr.length == 0){
            return -1;
        }
        int left = 0;
        int right = arr.length;
        while (left < right){           // 最后终止条件是left == right
            int mid = left + (right-left)/2;
            if(key < arr[mid]){
                right = mid;
                // 区间不断向右收缩
            }else if(key >= arr[mid]){
                left = mid+1;
            }
        }
        // left 一直左区间搜索   即key < arr中所有的数
        if (left == 0) return -1;
        // left = right 终止，left最大为arr.length, 其他情况判断arr[left-1]与key是否相等 返回-1
        return key == arr[left-1] ? left-1 : -1;
    }


    public static void main(String[] args) {
        int key = 1;
        int[] arr = {1, 3, 5, 7, 9, 11};
        int idx = binarySearch(key, arr);
        if(idx == -1){
            System.out.println(String.format("下标:%d ---> 值:%s", idx, "not find"));
        }else{
            System.out.println(String.format("下标:%d ---> 值:%d", idx, arr[idx]));
        }

        idx = binarySearch2(key, arr);
        if(idx == -1){
            System.out.println(String.format("下标:%d ---> 值:%s", idx, "not find"));
        }else{
            System.out.println(String.format("下标:%d ---> 值:%d", idx, arr[idx]));
        }

        idx = binarySearch3(key, arr, 0, arr.length-1);
        if(idx == -1){
            System.out.println(String.format("下标:%d ---> 值:%s", idx, "not find"));
        }else{
            System.out.println(String.format("下标:%d ---> 值:%d", idx, arr[idx]));
        }

        System.out.println("\n------------\n");
        int[] arr2 = {1, 2, 3, 3, 3, 3, 3, 5};
        int idx2 = binarySearchByLeft(key, arr2);
        if(idx2 == -1){
            System.out.println(String.format("下标:%d ---> 值:%s", idx2, "not find"));
        }else{
            System.out.println(String.format("下标:%d ---> 值:%d", idx2, arr2[idx2]));
        }

        System.out.println("\n------------\n");
        int idx3 = binarySearchByRight(key, arr2);
        if(idx3 == -1){
            System.out.println(String.format("下标:%d ---> 值:%s", idx3, "not find"));
        }else{
            System.out.println(String.format("下标:%d ---> 值:%d", idx3, arr2[idx3]));
        }

    }


}
