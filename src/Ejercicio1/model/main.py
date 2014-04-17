#!/usr/bin/python

v = [2, -4, 1, 6, 9, -10]

M = [[0 for i in range(len(v))] for j in range(len(v))]

def f(i,j,p):
	if( i == j ):
		F = v[i]
	
	elif( i == j-1 ):
		F = max(v[i], v[j])

	else:
		izq = max( [ sum(v[i:k])*p + f(k+1,j,(p+1)%2) for k in range(i,j) ])
		der = max( [ sum(v[k:j])*p + f(i  ,k,(p+1)%2) for k in range(i,j) ])

		F = max(izq, der)

	M[i][j] = F
	return F


print f(0, len(v)-1, 0)
#print f(3, 5, 0)

for i in range(len(M)): 
	print M[i]

