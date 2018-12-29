package com.cssl.tiantian.pojo;

import java.io.Serializable;
import java.util.List;

public class Page<x> implements Serializable {

    private static final long serialVersionUID = -8453782326227163722L;
    private int pageSize;
    private int pageNo;
    private int totalCount;
    private int totalPage;
    private List<x> list;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<x> getList() {
        return list;
    }

    public void setList(List<x> list) {
        this.list = list;
    }

    public static int[] getPageNumbers(int pageNo,int totalPage){
        //如果总页数不超过5个数，则把它们全部添加到数组中
        if (totalPage <= 5){
            int[] nums = new int[totalPage];
            for (int i=0;i<nums.length;i++){
                nums[i] = i + 1;
            }
            return nums;
        }else {
            //如果总页数超过5个数，则会产生3种情况，假设总共10页
            if (pageNo <= 3){
                //1、如果当前页码是1 、 2 、3，都是直接取前5个数字
                int[] nums = new int[5];
                for (int i=0;i<nums.length;i++){
                    nums[i] = i+1;
                }
                return nums;
            }else if (pageNo >= totalPage-2){
                //2、如果当前页码是10、9、8，就取后面的5个数字
                int[] nums = new int[5];
                for (int i=totalPage-4,index=0;i<=totalPage;i++,index++){
                    nums[index] = i;
                }
                return nums;
            }else {
                //否则就取中间的5个数字
                int[] nums = new int[5];
                for (int i=pageNo-2,index=0;i<=pageNo+2;i++,index++){
                    nums[index] = i;
                }
                return nums;
            }
        }
    }
}


















