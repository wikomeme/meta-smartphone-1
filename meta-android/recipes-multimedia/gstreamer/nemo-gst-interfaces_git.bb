SUMMARY = "Nemo mobile specific GStreamer interfaces"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-gst-interfaces/tree/master"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://git.merproject.org/mer-core/nemo-gst-interfaces.git;protocol=https"
SRCREV = "0128580bd75eb49bf378e4683e2b00f249f8ce0c"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS += "gstreamer1.0-plugins-base"

inherit autotools pkgconfig
