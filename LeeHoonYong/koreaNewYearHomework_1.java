package homeStudy;

import java.util.Scanner;

/**
 * 
 * @author 82108
 * A로봇은 오른쪽
 * 
 */
public class koreaNewYearHomework_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int t=0;t<T;t++) {
			int n;
			n=sc.nextInt();
			char[][] arr = new char[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					String s=sc.next();
					arr[i][j]=s.charAt(0);
				}
			}
			int result=0;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][j]=='A') {
						for(int k=j+1;k<n;k++) {
							if(arr[i][k]!='S') {
								break;
							}else {
								result++;
							}
						}
					}
					if(arr[i][j]=='B') {
						for(int k=j+1;k<n;k++) {
							if(arr[i][k]!='S') {
								break;
							}else {
								result++;
							}
						}
						for(int k=j-1;k>=0;k--) {
							if(arr[i][k]!='S') {
								break;
							}else {
								result++;
							}
						}
					}
					if(arr[i][j]=='C') {
						for(int k=j+1;k<n;k++) {
							if(arr[i][k]!='S') {
								break;
							}else {
		
								result++;
							}
						}
						for(int k=j-1;k>=0;k--) {
							if(arr[i][k]!='S') {
								break;
							}else {
								result++;
							}
						}
						for(int k=i-1;k>=0;k--) {
							if(arr[k][j]!='S') {
								break;
							}else {
								result++;
							}
						}
						for(int k=i+1;k<n;k++) {
							if(arr[k][j]!='S') {
								break;
							}else {
								result++;
							}
						}
					}
					
				}
			}
			System.out.println("#"+(t+1)+" "+result);	
		}

	}

}
