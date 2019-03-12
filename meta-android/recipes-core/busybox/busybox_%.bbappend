# build package busybox-mdev, needed by initramfs scripts
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	    file://mdev.cfg \
           "
