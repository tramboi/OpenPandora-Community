DESCRIPTION = "GemRB Game Engine"
HOMEPAGE = "http://gemrb.sourceforge.net"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r0"

DEPENDS = "virtual/libsdl openal python zlib"
 
SRC_URI = "http://sourceforge.net/projects/gemrb/files/GemRB%20Sources/GemRB%200.6.3%20Sources/gemrb-0.6.3.tar.gz\
           file://disable_werror.patch"

SRC_URI[md5sum] = "87a637a69d878d2bcab463ce085331f0"
SRC_URI[sha256sum] = "f627235f1031f0eb9b41eded430d717319077eb44686cfe21986d8c69933c768"

S = "${WORKDIR}/gemrb-0.6.3"

FILES_${PN}-dbg += "/usr/lib/gemrb/plugins/.debug"

inherit cmake

