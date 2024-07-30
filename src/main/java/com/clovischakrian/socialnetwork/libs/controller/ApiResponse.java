package com.clovischakrian.socialnetwork.libs.controller;

import java.util.List;

public record ApiResponse<T>(boolean success, T data, List<String> errors) {
}
