/*****************************************************************************
*
* Copyright (c) 2011, Allinea
* All rights reserved.
*
* This file has been contributed to the VisIt project, which is
* Copyright (c) Lawrence Livermore National Security, LLC. For  details, see
* https://visit.llnl.gov/.  The full copyright notice is contained in the 
* file COPYRIGHT located at the root of the VisIt distribution or at 
* http://www.llnl.gov/visit/copyright.html.
*
* Redistribution  and  use  in  source  and  binary  forms,  with  or  without
* modification, are permitted provided that the following conditions are met:
*
*  - Redistributions of  source code must  retain the above  copyright notice,
*    this list of conditions and the disclaimer below.
*  - Redistributions in binary form must reproduce the above copyright notice,
*    this  list of  conditions  and  the  disclaimer (as noted below)  in  the
*    documentation and/or other materials provided with the distribution.
*  - Neither the name of  the LLNS/LLNL nor the names of  its contributors may
*    be used to endorse or promote products derived from this software without
*    specific prior written permission.
*
* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT  HOLDERS AND CONTRIBUTORS "AS IS"
* AND ANY EXPRESS OR  IMPLIED WARRANTIES, INCLUDING,  BUT NOT  LIMITED TO, THE
* IMPLIED WARRANTIES OF MERCHANTABILITY AND  FITNESS FOR A PARTICULAR  PURPOSE
* ARE  DISCLAIMED. IN  NO EVENT  SHALL LAWRENCE  LIVERMORE NATIONAL  SECURITY,
* LLC, THE  U.S.  DEPARTMENT OF  ENERGY  OR  CONTRIBUTORS BE  LIABLE  FOR  ANY
* DIRECT,  INDIRECT,   INCIDENTAL,   SPECIAL,   EXEMPLARY,  OR   CONSEQUENTIAL
* DAMAGES (INCLUDING, BUT NOT  LIMITED TO, PROCUREMENT OF  SUBSTITUTE GOODS OR
* SERVICES; LOSS OF  USE, DATA, OR PROFITS; OR  BUSINESS INTERRUPTION) HOWEVER
* CAUSED  AND  ON  ANY  THEORY  OF  LIABILITY,  WHETHER  IN  CONTRACT,  STRICT
* LIABILITY, OR TORT  (INCLUDING NEGLIGENCE OR OTHERWISE)  ARISING IN ANY  WAY
* OUT OF THE  USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH
* DAMAGE.
*
*****************************************************************************/

#include "mpich.h"
#include "mpicompat/mpich2/mpi.h"
#include "mpicompat.h"

#include <dlfcn.h>
#include <stdio.h>
#include <stdlib.h>

static void* DDTSIM_dlhandle = NULL;
static MPI_Comm DDTSIM_mpi_comm_world;
static MPI_Datatype DDTSIM_mpi_int;
static MPI_Datatype DDTSIM_mpi_char;


void mpicompat_mpich_init()
{
    DDTSIM_mpi_comm_world = MPI_COMM_WORLD;
    DDTSIM_mpi_int = MPI_INT;
    DDTSIM_mpi_char = MPI_CHAR;
}

int mpicompat_mpich_Bcast(void *buffer, int count, int type, int root)
{
    int (*fptr)(void*,int,MPI_Datatype,int,MPI_Comm) =
            (int (*)(void*,int,MPI_Datatype,int,MPI_Comm)) dlsym(DDTSIM_dlhandle,"MPI_Bcast");

    if (fptr == NULL)
    {
        fprintf(stderr,"(ddtsim) Unable to load MPI_Bcast command: %s",dlerror());
        exit(1); // HOOKS_IGNORE
    }
    
    MPI_Datatype mpitype;
    switch(type)
    {
    case DDTSIM_MPI_INT:  mpitype = DDTSIM_mpi_int;  break;
    case DDTSIM_MPI_CHAR: mpitype = DDTSIM_mpi_char; break;
    default:
        fprintf(stderr,"(ddtsim) Unexpected use of ddtSim_Bcast with unhandled datatype\n");
        exit(1);  // HOOKS_IGNORE
    }

    return fptr(buffer,count,mpitype,root,DDTSIM_mpi_comm_world);
}

void mpicompat_mpich_rankAndSize(int *rank, int *size)
{
    ((int(*)(MPI_Comm,int*)) dlsym(DDTSIM_dlhandle,"MPI_Comm_rank"))(DDTSIM_mpi_comm_world,rank);
    ((int(*)(MPI_Comm,int*)) dlsym(DDTSIM_dlhandle,"MPI_Comm_size"))(DDTSIM_mpi_comm_world,size);
}
