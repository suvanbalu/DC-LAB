/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "sin.h"

float *
sine_1_svc(numbers *argp, struct svc_req *rqstp)
{
	static float  result;

	/*
	 * insert server code here
	 */
	printf("sine(%d) is called\n",argp->a);
	int i, n=10;
    float x=argp->a, sum, t;
     
    x=x*3.14159/180;
    t=x;
    sum=x;
     
    /* Loop to calculate the value of Sine */
    for(i=1;i<=n;i++)
    {
        t=(t*(-1)*x*x)/(2*i*(2*i+1));
        sum=sum+t;
    }
     
    result=sum;
    printf("\n%f\n",result);
	return &result;
}
