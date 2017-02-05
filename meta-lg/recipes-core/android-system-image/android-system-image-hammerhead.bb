require recipes-core/android-system-image/android-system-image.inc

COMPATIBLE_MACHINE = "hammerhead"

PV = "20170203-0"

# Fixing QA errors for not matching architecture for the following binaries:
# - /system/etc/firmware/vidc.b00
# - /system/etc/firmware/vidcfw.elf
# - /system/etc/firmware/vidc.mdt
INSANE_SKIP_${PN} = "arch"
# Fixing QA no GNU_HASH error for all binaries
INSANE_SKIP_${PN} += "ldflags"
# Fixing QA relocations in .text error for all binaries
INSANE_SKIP_${PN} += "textrel"

SRC_URI = "https://dl.dropboxusercontent.com/u/4679068/CM12.1-luneos-HAL/hal-droid-wop-13.0-20170204-0-hammerhead.tar.bz2"
#SRC_URI = "http://build.webos-ports.org/cm-wop-12.1/hal-droid-wop-12.1-${PV}-${MACHINE}.tar.bz2"
SRC_URI[md5sum] = "4b482cedf85b86b3dd537a9d41036b26"
SRC_URI[sha256sum] = "cb20d7835c1138393408c4e6e6538d955747f0bb702c758608c9772986569ebe"

do_install_prepend() {
    # fixup libGLESv3.so if needed
    if [ -h ${WORKDIR}/system/lib/libGLESv3.so ] ; then
        rm ${WORKDIR}/system/lib/libGLESv3.so
        cp ${WORKDIR}/system/lib/libGLESv2.so ${WORKDIR}/system/lib/libGLESv3.so
    fi

}
