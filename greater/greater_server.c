/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "greater.h"

int *
greater_1_svc(numbers *argp, struct svc_req *rqstp)
{
	static int  result;

	printf("greater(%d,%d,%d) is called\n", argp->a,argp->b,argp->c);
	if(argp->a >= argp->b && argp->a >= argp->c)
	result = argp->a;
	else if(argp->b >= argp->a && argp->b >= argp->c)
	result = argp->b;
	else
	result = argp->c;

	return &result;
}