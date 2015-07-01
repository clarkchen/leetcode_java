package RectangleArea;

/**
 * Created by chenxi on 15/7/1.
 */
public class Solution {
    private int max(int v1, int v2)
    {
        return v1>v2?v1:v2;
    }
    private int min(int v1, int v2)
    {
        return v1<v2?v1:v2;
    }
    private int getArea(int x1,int y1, int x2, int y2)
    {
        int l = Math.abs(x1 - x2);
        int r = Math.abs(y1 - y2);

        return l*r;
    }
    private boolean in_rencangle(int x, int y, int A, int B ,int C, int D)
    {
        return x>=A && x<=C && y>=B && y<=D;
    }

    private int getCommonArea(int A, int B, int C, int D, int E, int F, int G, int H )
    {
        int XL = max(A, E);
        int YL = max(B, F);
        int XR = min(C, G);
        int YR = min(D, H);
        int A_common = 0;
        if(in_rencangle(XL,YR,A,B,C,D) && in_rencangle(XL,YR, E,F,G,H) && in_rencangle(XR, YL, A,B,C,D) && in_rencangle(XR, YL, E,F,G,H))
        {
            A_common=getArea(XL, YL, XR, YR);
        }
        return A_common;
    }
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int A1 = getArea(A, B, C, D);
        int A2 = getArea(E,F,G,H);
        int A_common = getCommonArea(A,B,C,D,E,F,G,H);

        return A1+A2-A_common;
    }
}
