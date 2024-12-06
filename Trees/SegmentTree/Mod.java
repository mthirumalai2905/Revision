import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt(),q=sc.nextInt(),a[]=new int[n+5];
            for(int j=1;j<=n;j++){
                a[j]=sc.nextInt();
            }
            SegTree st=new SegTree(1,n);
            build(st,a);
            for(int j=0;j<q;j++){
                int l=sc.nextInt(),r=sc.nextInt();
                System.out.print(l==r?"0 ":find(st,l,r-1)+" ");
            }
            System.out.println();
        }
    }
    static int find(SegTree st,int a,int b){
        int l=st.l,r=st.r;
        if(l==a&&r==b){
            return st.gcd;
        }
        int mid=(l+r)>>1;
        return b<=mid?find(st.left,a,b):a>mid?find(st.right,a,b):gcd(find(st.left,a,mid),find(st.right,mid+1,b));
    }
    static void build(SegTree st,int a[]){
        int l=st.l,r=st.r;
        if(l==r){
            st.gcd=Math.abs(a[l]-a[l+1]);
        }
        else{
            int mid=(l+r)>>1;
            st.left=new SegTree(l,mid);
            st.right=new SegTree(mid+1,r);
            build(st.left,a);
            build(st.right,a);
            st.gcd=gcd(st.left.gcd,st.right.gcd);
        }
    }
    static int gcd(int a,int b){
        return a<b?gcd(b,a):b==0?a:gcd(a%b,b);
    }
}
class SegTree{
    SegTree left,right;
    int l,r,gcd;
    SegTree(int l,int r){
        this.l=l;
        this.r=r;
    }
}
