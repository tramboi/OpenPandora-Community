DESCRIPTION = "Vice C64 (and others) Emulator"
HOMEPAGE = "http://www.viceteam.org/"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r0"

DEPENDS = "libxt libxmu libxaw"
 
SRC_URI = "http://www.zimmers.net/anonftp/pub/cbm/crossplatform/emulators/VICE/vice-2.2.tar.gz \
           file://build.patch"

SRC_URI[md5sum] = "6737f540806205384e9129026898b0a1"
SRC_URI[sha256sum] = "5d581bf817c97f1887651f92e73dd1f5e3c14627fa86fc70732491be7cba1551"

S = "${WORKDIR}/vice-2.2"

inherit autotools

