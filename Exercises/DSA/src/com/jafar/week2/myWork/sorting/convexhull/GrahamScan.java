// package com.jafar.week2.myWork.sorting.convexhull;

// import java.util.Arrays;

// import edu.princeton.cs.algs4.Stack;

// public class GrahamScan {
    
//     public static int[] grahamScan(Integer[] p){
//         Stack<Point2D> hull = new Stack<Point2D>();

//         Arrays.sort(p,Point2D.Y_ORDER);
//         Arrays.sort(p,p[0].BY_POLAR_ORDER);

//         hull.push(p[0]);
//         hull.push(p[1]);

//         for(int i = 2; i< N;i++){
//             Point2D top = hull.pop();
//             while(Point2D.ccw(hull.peek,top,p[i]<=0)){
//                 top = hull.pop();
//             }
//             hull.push(top);
//             hull.push(p[i]);
//         }  
//     }
// }