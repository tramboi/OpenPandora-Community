DESCRIPTION = "Hatari ST Emulator"
HOMEPAGE = "http://hatari.berlios.de/"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r0"

DEPENDS = "virtual/libsdl zlib"
 
SRC_URI = "http://download.berlios.de/hatari/hatari-1.4.0.tar.bz2"
SRC_URI[md5sum] = "2f30e5c9e146ee92e3f2f5ae1cef3673"
SRC_URI[sha256sum] = "690e21bd2210a7e86af5d76ccc7f4e608aae37df466d2ead2ac4d105a637bc7b"

S = "${WORKDIR}/hatari-1.4.0"

inherit cmake

