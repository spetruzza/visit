##
## Setup VISITHOME variables.
##
SET(VISITHOME /home/biagas2/visit/thirdparty/3.0.0)
SET(VISITARCH linux-x86_64_gcc-6.3)

## Compiler flags.
##
VISIT_OPTION_DEFAULT(VISIT_C_COMPILER gcc TYPE FILEPATH)
VISIT_OPTION_DEFAULT(VISIT_CXX_COMPILER g++ TYPE FILEPATH)
VISIT_OPTION_DEFAULT(VISIT_FORTRAN_COMPILER no TYPE FILEPATH)
VISIT_OPTION_DEFAULT(VISIT_C_FLAGS " -m64 -fPIC -fvisibility=hidden" TYPE STRING)
VISIT_OPTION_DEFAULT(VISIT_CXX_FLAGS " -m64 -fPIC -fvisibility=hidden" TYPE STRING)

##
## VisIt Paradis Option
##
VISIT_OPTION_DEFAULT(VISIT_PARADIS OFF TYPE BOOL)

##
## VisIt Thread Option
##
VISIT_OPTION_DEFAULT(VISIT_THREAD OFF TYPE BOOL)

##
## 7-zip
##
VISIT_OPTION_DEFAULT(VISIT_SEVEN_ZIP_DIR ${VISITHOME}/p7zip)
VISIT_OPTION_DEFAULT(VISIT_DATA_ARCHIVER_NAME "7za" TYPE STRING)

##############################################################
##
## Database reader plugin support libraries
##
## The HDF4, HDF5 and NetCDF libraries must be first so that
## their libdeps are defined for any plugins that need them.
##
## For libraries with LIBDEP settings, order matters.
## Libraries with LIBDEP settings that depend on other
## Library's LIBDEP settings must come after them.
##############################################################
##

##
## ZLIB
##
VISIT_OPTION_DEFAULT(VISIT_ZLIB_DIR ${VISITHOME}/zlib/1.2.8/${VISITARCH})

##
## Python
##
VISIT_OPTION_DEFAULT(VISIT_PYTHON_DIR ${VISITHOME}/python/2.7.14/${VISITARCH})

##
## Qt
##
SETUP_APP_VERSION(QT 5.10.1)
VISIT_OPTION_DEFAULT(VISIT_QT_DIR ${VISITHOME}/qt/${QT_VERSION}/${VISITARCH})

##
## QWT
##
SETUP_APP_VERSION(QWT 6.1.2)
VISIT_OPTION_DEFAULT(VISIT_QWT_DIR ${VISITHOME}/qwt/${QWT_VERSION}/${VISITARCH})

##
## VTK
##

SETUP_APP_VERSION(VTK 8.1.0)
VISIT_OPTION_DEFAULT(VISIT_VTK_DIR ${VISITHOME}/vtk/${VTK_VERSION}/${VISITARCH})

##
## MPICH
##
# Give VisIt information so it can install MPI into the binary distribution.
if (VISIT_PARALLEL)
  VISIT_OPTION_DEFAULT(VISIT_MPICH_DIR ${VISITHOME}/mpich/3.0.4/${VISITARCH})
  VISIT_OPTION_DEFAULT(VISIT_MPICH_INSTALL ON TYPE BOOL)
  # Tell VisIt the parallel compiler so it can deduce parallel flags
  VISIT_OPTION_DEFAULT(VISIT_MPI_COMPILER ${VISIT_MPICH_DIR}/bin/mpicc TYPE FILEPATH)
endif()

##
## SZIP
##
VISIT_OPTION_DEFAULT(VISIT_SZIP_DIR ${VISITHOME}/szip/2.1/${VISITARCH})

##
## HDF5
##
VISIT_OPTION_DEFAULT(VISIT_HDF5_DIR ${VISITHOME}/hdf5/1.8.14/${VISITARCH})
VISIT_OPTION_DEFAULT(VISIT_HDF5_LIBDEP ${VISIT_SZIP_DIR}/lib sz ${VISIT_ZLIB_DIR}/lib z TYPE STRING)
if(VISIT_PARALLEL)
  VISIT_OPTION_DEFAULT(VISIT_HDF5_MPI_DIR ${VISITHOME}/hdf5_mpi/1.8.14/${VISITARCH})
  VISIT_OPTION_DEFAULT(VISIT_HDF5_MPI_LIBDEP ${VISIT_SZIP_DIR}/lib sz ${VISIT_ZLIB_DIR}/lib z TYPE STRING)
endif()

##
## AdvIO
##
VISIT_OPTION_DEFAULT(VISIT_ADVIO_DIR ${VISITHOME}/AdvIO/1.2/${VISITARCH})

##
## BOOST
##
SETUP_APP_VERSION(BOOST 1_67_0)
VISIT_OPTION_DEFAULT(VISIT_BOOST_DIR ${VISITHOME}/boost/${BOOST_VERSION}/${VISITARCH})

##
## Boxlib
##
VISIT_OPTION_DEFAULT(VISIT_BOXLIB_DIR ${VISITHOME}/boxlib/1.3.5/${VISITARCH})

##
## CCMIO
##
VISIT_OPTION_DEFAULT(VISIT_CCMIO_DIR ${VISITHOME}/ccmio/2.6.1/${VISITARCH})

##
## CFITSIO
##
VISIT_OPTION_DEFAULT(VISIT_CFITSIO_DIR ${VISITHOME}/cfitsio/3006/${VISITARCH})

##
## CGNS
##
VISIT_OPTION_DEFAULT(VISIT_CGNS_DIR ${VISITHOME}/cgns/3.2.1/${VISITARCH})
VISIT_OPTION_DEFAULT(VISIT_CGNS_LIBDEP HDF5_LIBRARY_DIR hdf5 ${VISIT_HDF5_LIBDEP} TYPE STRING)

##
## Conduit
##
VISIT_OPTION_DEFAULT(VISIT_CONDUIT_DIR ${VISITHOME}/conduit/v0.3.1/${VISITARCH})
VISIT_OPTION_DEFAULT(VISIT_CONDUIT_LIBDEP HDF5_LIBRARY_DIR hdf5 ${VISIT_HDF5_LIBDEP} TYPE STRING)

##
## GDAL
##
VISIT_OPTION_DEFAULT(VISIT_GDAL_DIR ${VISITHOME}/gdal/2.2.4/${VISITARCH})

##
## H5Part
##
SETUP_APP_VERSION(H5PART 1.6.6)
VISIT_OPTION_DEFAULT(VISIT_H5PART_DIR ${VISITHOME}/h5part/${H5PART_VERSION}/${VISITARCH})
VISIT_OPTION_DEFAULT(VISIT_H5PART_LIBDEP HDF5_LIBRARY_DIR hdf5 ${VISIT_HDF5_LIBDEP} TYPE STRING)

##
## HDF4
##
VISIT_OPTION_DEFAULT(VISIT_HDF4_DIR ${VISITHOME}/hdf4/4.2.5/${VISITARCH})
VISIT_OPTION_DEFAULT(VISIT_HDF4_LIBDEP ${VISIT_SZIP_DIR}/lib sz vtkjpeg TYPE STRING)

##
## Ice-T
##
if(VISIT_PARALLEL)
VISIT_OPTION_DEFAULT(VISIT_ICET_DIR ${VISITHOME}/icet/77c708f9090236b576669b74c53e9f105eedbd7e/${VISITARCH})
endif()

##
## MFEM 
##
VISIT_OPTION_DEFAULT(VISIT_MFEM_DIR ${VISITHOME}/mfem/3.3/${VISITARCH})
VISIT_OPTION_DEFAULT(VISIT_MFEM_LIBDEP ${VISITHOME}/zlib/1.2.8/${VISITARCH}/lib z TYPE STRING)

##
## Mili
##
VISIT_OPTION_DEFAULT(VISIT_MILI_DIR ${VISITHOME}/mili/15.1/${VISITARCH})

##
## MOAB 
##
VISIT_OPTION_DEFAULT(VISIT_MOAB_DIR ${VISITHOME}/moab/4.9.2-RC0/${VISITARCH})
VISIT_OPTION_DEFAULT(VISIT_MOAB_LIBDEP HDF5_LIBRARY_DIR hdf5 ${VISIT_HDF5_LIBDEP} TYPE STRING)
if(VISIT_PARALLEL)
  VISIT_OPTION_DEFAULT(VISIT_MOAB_MPI_DIR ${VISITHOME}/moab_mpi/4.9.2-RC0/${VISITARCH})
  VISIT_OPTION_DEFAULT(VISIT_MOAB_MPI_LIBDEP HDF5_MPI_LIBRARY_DIR hdf5_mpi ${VISIT_HDF5_MPI_LIBDEP} TYPE STRING)
endif()
##

##
## NetCDF
##
VISIT_OPTION_DEFAULT(VISIT_NETCDF_DIR ${VISITHOME}/netcdf/4.1.1/${VISITARCH})
VISIT_OPTION_DEFAULT(VISIT_NETCDF_LIBDEP HDF5_LIBRARY_DIR hdf5_hl HDF5_LIBRARY_DIR hdf5 ${VISIT_HDF5_LIBDEP} TYPE STRING)

##
## OpenEXR
##
VISIT_OPTION_DEFAULT(VISIT_OPENEXR_DIR ${VISITHOME}/openexr/2.2.0/${VISITARCH})

##
## Silo
##
VISIT_OPTION_DEFAULT(VISIT_SILO_DIR ${VISITHOME}/silo/4.10.2/${VISITARCH})
VISIT_OPTION_DEFAULT(VISIT_SILO_LIBDEP HDF5_LIBRARY_DIR hdf5 ${VISIT_HDF5_LIBDEP} TYPE STRING)

##
## Xdmf
##
VISIT_OPTION_DEFAULT(VISIT_XDMF_DIR ${VISITHOME}/Xdmf/2.1.1/${VISITARCH})
VISIT_OPTION_DEFAULT(VISIT_XDMF_LIBDEP HDF5_LIBRARY_DIR hdf5 vtklibxml2 TYPE STRING)

