DESCRIPTION = "Kernel drivers for the TI1251 WiFi chip found on the Pandora - Connected via SDIO"
LICENSE = "GPLv2"

# Check the include for the source location/GIT SRCREV etc.
require pandora-wifi.inc

SRC_URI += " \
	file://rc.tiwifi \
#	file://0001-Initial-work-on-WEXT-support.patch;patch=1 \
#	file://0002-More-cleanup-work-on-WEXT.-Now-at-the-point-that-use.patch;patch=1 \
#	file://0003-Oooops-now-lets-try-something-that-compiles.patch;patch=1 \
#	file://0004-Clean-up-to-use-IW_RETRY_LONG-and-IW_RETRY_SHORT.patch;patch=1 \
#	file://0005-Fix-ooops-I-really-don-t-want-funky-private-features.patch;patch=1 \
	file://0001-Fix-in-wlan_cu-makefile-to-make-OUTPUT_DIR-not-fixed.patch;patch=1 \
	file://0002-Add-in-the-start-of-wireless-extensions-support-ioct.patch;patch=1 \
	file://0003-Merge-in-latest-wireless-ext.-hacks.patch;patch=1 \
	file://0004-Default-to-DEBUG-Y-for-testing.patch;patch=1 \
	file://0005-More-WEXT-cleanup.patch;patch=1 \	
	file://0006-Add-back-in-missing-header-o.patch;patch=1 \
	file://0007-Add-iw_ioctl.h-header.patch;patch=1 \
	file://0008-Update-Wireless-EXT-with-test-code.patch;patch=1 \
"

inherit update-rc.d

INITSCRIPT_NAME = "tiwifi-init"
INITSCRIPT_PARAMS = "stop 40 0 1 6 ."

do_compile_prepend() {
          cd ${S}/sta_dk_4_0_4_32/
}

do_install() {
          cd ${S}/sta_dk_4_0_4_32/
          mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/tiwlan
          cp ${S}/sta_dk_4_0_4_32/*.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/tiwlan
          install -d ${D}${sysconfdir}/init.d/
          cp -pP ${WORKDIR}/rc.tiwifi ${D}${sysconfdir}/init.d/tiwifi-init
          cp -pP ${S}/sta_dk_4_0_4_32/fw/tiwlan.ini ${D}${sysconfdir}/tiwlan.ini         
}

FILES_${PN} += "/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/tiwlan/*.ko.*"
