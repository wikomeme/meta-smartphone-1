require recipes-kernel/linux/linux.inc

SECTION = "kernel"

# Mark archs/machines that this kernel supports
COMPATIBLE_MACHINE = "hammerhead"

DESCRIPTION = "Linux kernel for the LG Hammerhead (Nexus 5) device based on the offical \
source from Google/LG"

CMDLINE = "androidboot.hardware=hammerhead user_debug=31 maxcpus=2 msm_watchdog_v2.enable=1"
KERNEL_RAM_BASE = "0x00008000"
RAMDISK_RAM_BASE = "0x02900000"
SECOND_RAM_BASE = "0x00f00000"
TAGS_RAM_BASE = "0x02700000"

inherit kernel_android

SRC_URI = " \
  git://github.com/Tofee/android_kernel_lge_hammerhead.git;protocol=git;branch=hammerhead/3.4/cm-13.0 \
  file://defconfig \
"
S = "${WORKDIR}/git"

SRCREV = "cf678109aec7a593a174fd51818d416b6ac300cf"

KV = "3.4.0"
PV = "${KV}+gitr${SRCPV}"
# for bumping PR bump MACHINE_KERNEL_PR in the machine config
inherit machine_kernel_pr
