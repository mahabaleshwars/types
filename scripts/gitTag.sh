#!/bin/sh

# Copyright 2023 Loïc Lamarque.
# Use of this source code is governed by the MIT license.

# This scripts tags a stable release of Kotools Types.

TAG_NAME=$1
git tag "$TAG_NAME" -s -m "Stable release of Kotools Types $TAG_NAME." && \
git push origin "$TAG_NAME" -f
