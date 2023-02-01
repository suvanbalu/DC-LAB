/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#ifndef _SIN_H_RPCGEN
#define _SIN_H_RPCGEN

#include <rpc/rpc.h>


#ifdef __cplusplus
extern "C" {
#endif


struct numbers {
	int a;
};
typedef struct numbers numbers;

#define ADD_PROG 0x4562877
#define ADD_VERS 1

#if defined(__STDC__) || defined(__cplusplus)
#define sine 1
extern  int * sine_1(numbers *, CLIENT *);
extern  float * sine_1_svc(numbers *, struct svc_req *);
extern int add_prog_1_freeresult (SVCXPRT *, xdrproc_t, caddr_t);

#else /* K&R C */
#define sine 1
extern  int * sine_1();
extern  int * sine_1_svc();
extern int add_prog_1_freeresult ();
#endif /* K&R C */

/* the xdr functions */

#if defined(__STDC__) || defined(__cplusplus)
extern  bool_t xdr_numbers (XDR *, numbers*);

#else /* K&R C */
extern bool_t xdr_numbers ();

#endif /* K&R C */

#ifdef __cplusplus
}
#endif

#endif /* !_SIN_H_RPCGEN */
