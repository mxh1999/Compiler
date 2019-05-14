global main
SECTION .text

_array_size_func:
        mov     rax, [rdi]
        ret





default rel

global print_func
global println_func
global getString_func
global getInt_func
global toString_func
global _string_length_func
global _string_substring_func
global _string_parseInt_func
global _string_ord_func
global _string_add_func
global _string_less_func
global _string_lessequal_func
global _string_great_func
global _string_greaterequal_func
global _string_equal_func
global _string_notequal_func

extern strcmp
extern strcpy
extern strlen
extern __stack_chk_fail
extern __isoc99_scanf
extern malloc
extern puts
extern printf
extern _GLOBAL_OFFSET_TABLE_


SECTION .text   

print_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     rax, qword [rbp-8H]
        mov     rsi, rax
        lea     rdi, [rel L_017]
        mov     eax, 0
        call    printf
        nop
        leave
        ret


println_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     rax, qword [rbp-8H]
        mov     rdi, rax
        call    puts
        nop
        leave
        ret


getString_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     edi, 256
        call    malloc
        mov     qword [rbp-8H], rax
        mov     rax, qword [rbp-8H]
        mov     rsi, rax
        lea     rdi, [rel L_017]
        mov     eax, 0
        call    __isoc99_scanf
        mov     rax, qword [rbp-8H]
        leave
        ret


getInt_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16


        mov     rax, qword [fs:abs 28H]
        mov     qword [rbp-8H], rax
        xor     eax, eax
        lea     rax, [rbp-10H]
        mov     rsi, rax
        lea     rdi, [rel L_018]
        mov     eax, 0
        call    __isoc99_scanf
        mov     rax, qword [rbp-10H]
        mov     rdx, qword [rbp-8H]


        xor     rdx, qword [fs:abs 28H]
        jz      L_001
        call    __stack_chk_fail
L_001:  leave
        ret


toString_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 48
        mov     qword [rbp-28H], rdi
        mov     rax, qword [rbp-28H]
        mov     qword [rbp-20H], rax
        mov     qword [rbp-18H], 0
        cmp     qword [rbp-20H], 0
        jns     L_002
        add     qword [rbp-18H], 1
        neg     qword [rbp-20H]
L_002:  cmp     qword [rbp-20H], 0
        jnz     L_004
        add     qword [rbp-18H], 1
        jmp     L_004

L_003:  add     qword [rbp-18H], 1
        mov     rcx, qword [rbp-20H]
        mov     rdx, qword 6666666666666667H
        mov     rax, rcx
        imul    rdx
        sar     rdx, 2
        mov     rax, rcx
        sar     rax, 63
        sub     rdx, rax
        mov     rax, rdx
        mov     qword [rbp-20H], rax
L_004:  cmp     qword [rbp-20H], 0
        jnz     L_003
        mov     rax, qword [rbp-18H]
        add     rax, 1
        mov     rdi, rax
        call    malloc
        mov     qword [rbp-8H], rax
        mov     rdx, qword [rbp-18H]
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     byte [rax], 0
        cmp     qword [rbp-28H], 0
        jns     L_005
        mov     rax, qword [rbp-8H]
        mov     byte [rax], 45
        neg     qword [rbp-28H]
L_005:  cmp     qword [rbp-28H], 0
        jnz     L_006
        mov     rax, qword [rbp-8H]
        mov     byte [rax], 48
        mov     rax, qword [rbp-8H]
        jmp     L_011

L_006:  mov     rax, qword [rbp-18H]
        sub     rax, 1
        mov     qword [rbp-10H], rax
        jmp     L_008

L_007:  mov     rcx, qword [rbp-28H]
        mov     rdx, qword 6666666666666667H
        mov     rax, rcx
        imul    rdx
        sar     rdx, 2
        mov     rax, rcx
        sar     rax, 63
        sub     rdx, rax
        mov     rax, rdx
        shl     rax, 2
        add     rax, rdx
        add     rax, rax
        sub     rcx, rax
        mov     rdx, rcx
        mov     eax, edx
        lea     ecx, [rax+30H]
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     edx, ecx
        mov     byte [rax], dl
        mov     rcx, qword [rbp-28H]
        mov     rdx, qword 6666666666666667H
        mov     rax, rcx
        imul    rdx
        sar     rdx, 2
        mov     rax, rcx
        sar     rax, 63
        sub     rdx, rax
        mov     rax, rdx
        mov     qword [rbp-28H], rax
        cmp     qword [rbp-28H], 0
        jz      L_009
        sub     qword [rbp-10H], 1
L_008:  cmp     qword [rbp-10H], 0
        jns     L_007
        jmp     L_010

L_009:  nop
L_010:  mov     rax, qword [rbp-8H]
L_011:  leave
        ret


_string_length_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     rax, qword [rbp-8H]
        mov     rdi, rax
        call    strlen
        leave
        ret


_string_substring_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 64
        mov     qword [rbp-28H], rdi
        mov     qword [rbp-30H], rsi
        mov     qword [rbp-38H], rdx
        mov     rax, qword [rbp-38H]
        sub     rax, qword [rbp-30H]
        add     rax, 2
        mov     qword [rbp-10H], rax
        mov     rax, qword [rbp-10H]
        mov     rdi, rax
        call    malloc
        mov     qword [rbp-8H], rax
        mov     rax, qword [rbp-10H]
        lea     rdx, [rax-1H]
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     byte [rax], 0
        mov     rax, qword [rbp-30H]
        mov     qword [rbp-18H], rax
        jmp     L_013

L_012:  mov     rdx, qword [rbp-18H]
        mov     rax, qword [rbp-28H]
        lea     rcx, [rdx+rax]
        mov     rax, qword [rbp-18H]
        sub     rax, qword [rbp-30H]
        mov     rdx, rax
        mov     rax, qword [rbp-8H]
        add     rdx, rax
        movzx   eax, byte [rcx]
        mov     byte [rdx], al
        add     qword [rbp-18H], 1
L_013:  mov     rax, qword [rbp-18H]
        cmp     rax, qword [rbp-38H]
        jle     L_012
        mov     rax, qword [rbp-8H]
        leave
        ret


_string_parseInt_func:
        push    rbp
        mov     rbp, rsp
        mov     qword [rbp-18H], rdi
        mov     qword [rbp-10H], 0
        mov     rax, qword [rbp-18H]
        mov     qword [rbp-8H], rax
        jmp     L_015

L_014:  mov     rdx, qword [rbp-10H]
        mov     rax, rdx
        shl     rax, 2
        add     rax, rdx
        add     rax, rax
        mov     rdx, rax
        mov     rax, qword [rbp-8H]
        movzx   eax, byte [rax]
        movsx   rax, al
        add     rax, rdx
        sub     rax, 48
        mov     qword [rbp-10H], rax
        add     qword [rbp-8H], 1
L_015:  mov     rax, qword [rbp-8H]
        movzx   eax, byte [rax]
        cmp     al, 57
        jg      L_016
        mov     rax, qword [rbp-8H]
        movzx   eax, byte [rax]
        cmp     al, 47
        jg      L_014
L_016:  mov     rax, qword [rbp-10H]
        pop     rbp
        ret


_string_ord_func:
        push    rbp
        mov     rbp, rsp
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        movzx   eax, byte [rax]
        movsx   rax, al
        pop     rbp
        ret


_string_add_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 48
        mov     qword [rbp-28H], rdi
        mov     qword [rbp-30H], rsi
        mov     rax, qword [rbp-28H]
        mov     rdi, rax
        call    strlen
        mov     qword [rbp-18H], rax
        mov     rax, qword [rbp-30H]
        mov     rdi, rax
        call    strlen
        mov     qword [rbp-10H], rax
        mov     rdx, qword [rbp-18H]
        mov     rax, qword [rbp-10H]
        add     rax, rdx
        add     rax, 1
        mov     rdi, rax
        call    malloc
        mov     qword [rbp-8H], rax
        mov     rdx, qword [rbp-28H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcpy
        mov     rdx, qword [rbp-18H]
        mov     rax, qword [rbp-8H]
        add     rdx, rax
        mov     rax, qword [rbp-30H]
        mov     rsi, rax
        mov     rdi, rdx
        call    strcpy
        mov     rdx, qword [rbp-18H]
        mov     rax, qword [rbp-10H]
        add     rax, rdx
        mov     rdx, rax
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     byte [rax], 0
        mov     rax, qword [rbp-8H]
        leave
        ret


_string_less_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        shr     eax, 31
        leave
        ret


_string_lessequal_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        setle   al
        leave
        ret


_string_great_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        setg    al
        leave
        ret


_string_greaterequal_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        not     eax
        shr     eax, 31
        leave
        ret


_string_equal_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        sete    al
        leave
        ret


_string_notequal_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        setne   al
        leave
        ret



SECTION .data   


SECTION .bss    


SECTION .rodata 

L_017:
        db 25H, 73H, 00H

L_018:
        db 25H, 6CH, 64H, 00H


section .text
main:
          push      rbp
          mov       rbp, rsp
Lab_1:
          mov       r10, 100
          mov       qword [@hashsize_var], r10
          call      main_func
          leave     
          ret       

getHash_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 48
          mov       qword [rbp-8], rdi
Lab_2:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-16], r10
          mov       r10, qword [rbp-16]
          imul      r10, 237
          mov       qword [rbp-24], r10
          mov       r10, qword [@hashsize_var]
          mov       qword [rbp-32], r10
          xor       rdx, rdx
          mov       rax, qword [rbp-24]
          mov       r10, qword [rbp-32]
          idiv      r10
          mov       qword [rbp-40], rdx
          mov       rax, qword [rbp-40]
          leave     
          ret       
          leave     
          ret       

put_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 640
          mov       qword [rbp-32], rdi
          mov       qword [rbp-24], rsi
Lab_3:
          mov       r10, qword [rbp-32]
          mov       qword [rbp-40], r10
          mov       rdi, qword [rbp-40]
          call      getHash_func
          mov       qword [rbp-48], rax
          mov       r10, qword [rbp-48]
          mov       qword [rbp-16], r10
          mov       r10, qword [rbp-32]
          mov       qword [rbp-56], r10
          mov       rdi, qword [rbp-56]
          call      toString_func
          mov       qword [rbp-64], rax
          mov       rdi, qword [rbp-64]
          call      print_func
          mov       rdi, const_1_cs
          call      print_func
          mov       r10, qword [rbp-24]
          mov       qword [rbp-72], r10
          mov       rdi, qword [rbp-72]
          call      toString_func
          mov       qword [rbp-80], rax
          mov       rdi, qword [rbp-80]
          call      println_func
          jmp       Lab_4
Lab_4:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-88], r10
          mov       r10, qword [@table_var]
          mov       qword [rbp-96], r10
          mov       r10, qword [rbp-88]
          imul      r10, 8
          mov       qword [rbp-104], r10
          mov       r10, qword [rbp-104]
          add       r10, 8
          mov       qword [rbp-112], r10
          mov       r10, qword [rbp-96]
          add       r10, qword [rbp-112]
          mov       qword [rbp-120], r10
          mov       r11, qword [rbp-120]
          mov       r10, [r11]
          mov       qword [rbp-128], r10
          mov       r10, qword [rbp-128]
          xor       rax, rax
          cmp       r10, const_2_cs
          sete      al
          mov       qword [rbp-136], rax
          cmp       qword [rbp-136], 0
          jnz       Lab_5
          jmp       Lab_6
Lab_5:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-144], r10
          mov       r10, qword [@table_var]
          mov       qword [rbp-152], r10
          mov       r10, qword [rbp-144]
          imul      r10, 8
          mov       qword [rbp-160], r10
          mov       r10, qword [rbp-160]
          add       r10, 8
          mov       qword [rbp-168], r10
          mov       r10, qword [rbp-152]
          add       r10, qword [rbp-168]
          mov       qword [rbp-176], r10
          mov       rdi, 24
          call      malloc
          mov       qword [rbp-184], rax
          mov       r10, qword [rbp-184]
          mov       r11, qword [rbp-176]
          mov       [r11], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-192], r10
          mov       r10, qword [@table_var]
          mov       qword [rbp-200], r10
          mov       r10, qword [rbp-192]
          imul      r10, 8
          mov       qword [rbp-208], r10
          mov       r10, qword [rbp-208]
          add       r10, 8
          mov       qword [rbp-216], r10
          mov       r10, qword [rbp-200]
          add       r10, qword [rbp-216]
          mov       qword [rbp-224], r10
          mov       r11, qword [rbp-224]
          mov       r10, [r11]
          mov       qword [rbp-232], r10
          mov       r10, qword [rbp-232]
          add       r10, 8
          mov       qword [rbp-240], r10
          mov       r10, qword [rbp-32]
          mov       qword [rbp-248], r10
          mov       r10, qword [rbp-248]
          mov       r11, qword [rbp-240]
          mov       [r11], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-256], r10
          mov       r10, qword [@table_var]
          mov       qword [rbp-264], r10
          mov       r10, qword [rbp-256]
          imul      r10, 8
          mov       qword [rbp-272], r10
          mov       r10, qword [rbp-272]
          add       r10, 8
          mov       qword [rbp-280], r10
          mov       r10, qword [rbp-264]
          add       r10, qword [rbp-280]
          mov       qword [rbp-288], r10
          mov       r11, qword [rbp-288]
          mov       r10, [r11]
          mov       qword [rbp-296], r10
          mov       r10, qword [rbp-296]
          add       r10, 16
          mov       qword [rbp-304], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-312], r10
          mov       r10, qword [rbp-312]
          mov       r11, qword [rbp-304]
          mov       [r11], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-320], r10
          mov       r10, qword [@table_var]
          mov       qword [rbp-328], r10
          mov       r10, qword [rbp-320]
          imul      r10, 8
          mov       qword [rbp-336], r10
          mov       r10, qword [rbp-336]
          add       r10, 8
          mov       qword [rbp-344], r10
          mov       r10, qword [rbp-328]
          add       r10, qword [rbp-344]
          mov       qword [rbp-352], r10
          mov       r11, qword [rbp-352]
          mov       r10, [r11]
          mov       qword [rbp-360], r10
          mov       r10, qword [rbp-360]
          add       r10, 24
          mov       qword [rbp-368], r10
          mov       r10, const_2_cs
          mov       r11, qword [rbp-368]
          mov       [r11], r10
          leave     
          ret       
Lab_6:
          jmp       Lab_7
Lab_7:
          mov       rdi, const_3_cs
          call      println_func
          mov       r10, qword [rbp-16]
          mov       qword [rbp-376], r10
          mov       r10, qword [@table_var]
          mov       qword [rbp-384], r10
          mov       r10, qword [rbp-376]
          imul      r10, 8
          mov       qword [rbp-392], r10
          mov       r10, qword [rbp-392]
          add       r10, 8
          mov       qword [rbp-400], r10
          mov       r10, qword [rbp-384]
          add       r10, qword [rbp-400]
          mov       qword [rbp-408], r10
          mov       r11, qword [rbp-408]
          mov       r10, [r11]
          mov       qword [rbp-416], r10
          mov       r10, qword [rbp-416]
          mov       qword [rbp-8], r10
          jmp       Lab_8
Lab_8:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-424], r10
          mov       r10, qword [rbp-424]
          add       r10, 8
          mov       qword [rbp-432], r10
          mov       r11, qword [rbp-432]
          mov       r10, [r11]
          mov       qword [rbp-440], r10
          mov       r10, qword [rbp-32]
          mov       qword [rbp-448], r10
          mov       r10, qword [rbp-440]
          xor       rax, rax
          cmp       r10, qword [rbp-448]
          setne     al
          mov       qword [rbp-456], rax
          cmp       qword [rbp-456], 0
          jnz       Lab_9
          jmp       Lab_10
Lab_9:
          jmp       Lab_11
Lab_10:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-464], r10
          mov       r10, qword [rbp-464]
          add       r10, 16
          mov       qword [rbp-472], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-480], r10
          mov       r10, qword [rbp-480]
          mov       r11, qword [rbp-472]
          mov       [r11], r10
          leave     
          ret       
Lab_11:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-488], r10
          mov       r10, qword [rbp-488]
          add       r10, 24
          mov       qword [rbp-496], r10
          mov       r11, qword [rbp-496]
          mov       r10, [r11]
          mov       qword [rbp-504], r10
          mov       r10, qword [rbp-504]
          xor       rax, rax
          cmp       r10, const_2_cs
          sete      al
          mov       qword [rbp-512], rax
          cmp       qword [rbp-512], 0
          jnz       Lab_12
          jmp       Lab_13
Lab_12:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-520], r10
          mov       r10, qword [rbp-520]
          add       r10, 24
          mov       qword [rbp-528], r10
          mov       rdi, 24
          call      malloc
          mov       qword [rbp-536], rax
          mov       r10, qword [rbp-536]
          mov       r11, qword [rbp-528]
          mov       [r11], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-544], r10
          mov       r10, qword [rbp-544]
          add       r10, 24
          mov       qword [rbp-552], r10
          mov       r11, qword [rbp-552]
          mov       r10, [r11]
          mov       qword [rbp-560], r10
          mov       r10, qword [rbp-560]
          add       r10, 8
          mov       qword [rbp-568], r10
          mov       r10, qword [rbp-32]
          mov       qword [rbp-576], r10
          mov       r10, qword [rbp-576]
          mov       r11, qword [rbp-568]
          mov       [r11], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-584], r10
          mov       r10, qword [rbp-584]
          add       r10, 24
          mov       qword [rbp-592], r10
          mov       r11, qword [rbp-592]
          mov       r10, [r11]
          mov       qword [rbp-600], r10
          mov       r10, qword [rbp-600]
          add       r10, 24
          mov       qword [rbp-608], r10
          mov       r10, const_2_cs
          mov       r11, qword [rbp-608]
          mov       [r11], r10
          jmp       Lab_14
Lab_13:
          jmp       Lab_14
Lab_14:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-616], r10
          mov       r10, qword [rbp-616]
          add       r10, 24
          mov       qword [rbp-624], r10
          mov       r11, qword [rbp-624]
          mov       r10, [r11]
          mov       qword [rbp-632], r10
          mov       r10, qword [rbp-632]
          mov       qword [rbp-8], r10
          jmp       Lab_8
          leave     
          ret       

get_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 160
          mov       qword [rbp-16], rdi
Lab_15:
          mov       r10, qword [rbp-16]
          mov       qword [rbp-24], r10
          mov       rdi, qword [rbp-24]
          call      getHash_func
          mov       qword [rbp-32], rax
          mov       r10, qword [@table_var]
          mov       qword [rbp-40], r10
          mov       r10, qword [rbp-32]
          imul      r10, 8
          mov       qword [rbp-48], r10
          mov       r10, qword [rbp-48]
          add       r10, 8
          mov       qword [rbp-56], r10
          mov       r10, qword [rbp-40]
          add       r10, qword [rbp-56]
          mov       qword [rbp-64], r10
          mov       r11, qword [rbp-64]
          mov       r10, [r11]
          mov       qword [rbp-72], r10
          mov       r10, qword [rbp-72]
          mov       qword [rbp-8], r10
          jmp       Lab_16
Lab_16:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-80], r10
          mov       r10, qword [rbp-80]
          add       r10, 8
          mov       qword [rbp-88], r10
          mov       r11, qword [rbp-88]
          mov       r10, [r11]
          mov       qword [rbp-96], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-104], r10
          mov       r10, qword [rbp-96]
          xor       rax, rax
          cmp       r10, qword [rbp-104]
          setne     al
          mov       qword [rbp-112], rax
          cmp       qword [rbp-112], 0
          jnz       Lab_17
          jmp       Lab_18
Lab_17:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-120], r10
          mov       r10, qword [rbp-120]
          add       r10, 24
          mov       qword [rbp-128], r10
          mov       r11, qword [rbp-128]
          mov       r10, [r11]
          mov       qword [rbp-136], r10
          mov       r10, qword [rbp-136]
          mov       qword [rbp-8], r10
          jmp       Lab_16
Lab_18:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-144], r10
          mov       r10, qword [rbp-144]
          add       r10, 16
          mov       qword [rbp-152], r10
          mov       r11, qword [rbp-152]
          mov       r10, [r11]
          mov       qword [rbp-160], r10
          mov       rax, qword [rbp-160]
          leave     
          ret       
          leave     
          ret       

main_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 256
Lab_19:
          mov       r10, 100
          imul      r10, 8
          mov       qword [rbp-16], r10
          mov       r10, qword [rbp-16]
          add       r10, 8
          mov       qword [rbp-24], r10
          mov       rdi, qword [rbp-24]
          call      malloc
          mov       qword [rbp-32], rax
          mov       r10, 100
          mov       r11, qword [rbp-32]
          mov       [r11], r10
          mov       r10, qword [rbp-32]
          mov       qword [@table_var], r10
          mov       r10, 0
          mov       qword [rbp-8], r10
          jmp       Lab_20
Lab_20:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-40], r10
          mov       r10, qword [@hashsize_var]
          mov       qword [rbp-48], r10
          mov       r10, qword [rbp-40]
          xor       rax, rax
          cmp       r10, qword [rbp-48]
          setl      al
          mov       qword [rbp-56], rax
          cmp       qword [rbp-56], 0
          jnz       Lab_21
          jmp       Lab_23
Lab_21:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-64], r10
          mov       r10, qword [@table_var]
          mov       qword [rbp-72], r10
          mov       r10, qword [rbp-64]
          imul      r10, 8
          mov       qword [rbp-80], r10
          mov       r10, qword [rbp-80]
          add       r10, 8
          mov       qword [rbp-88], r10
          mov       r10, qword [rbp-72]
          add       r10, qword [rbp-88]
          mov       qword [rbp-96], r10
          mov       r10, const_2_cs
          mov       r11, qword [rbp-96]
          mov       [r11], r10
          jmp       Lab_22
Lab_22:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-104], r10
          mov       r10, qword [rbp-104]
          add       r10, 1
          mov       qword [rbp-112], r10
          mov       r10, qword [rbp-112]
          mov       qword [rbp-8], r10
          jmp       Lab_20
Lab_23:
          mov       r10, 0
          mov       qword [rbp-8], r10
          jmp       Lab_24
Lab_24:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-120], r10
          mov       r10, qword [rbp-120]
          xor       rax, rax
          cmp       r10, 1000
          setl      al
          mov       qword [rbp-128], rax
          cmp       qword [rbp-128], 0
          jnz       Lab_25
          jmp       Lab_27
Lab_25:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-136], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-144], r10
          mov       rdi, qword [rbp-136]
          mov       rsi, qword [rbp-144]
          call      put_func
          jmp       Lab_26
Lab_26:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-152], r10
          mov       r10, qword [rbp-152]
          add       r10, 1
          mov       qword [rbp-160], r10
          mov       r10, qword [rbp-160]
          mov       qword [rbp-8], r10
          jmp       Lab_24
Lab_27:
          mov       r10, 0
          mov       qword [rbp-8], r10
          jmp       Lab_28
Lab_28:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-168], r10
          mov       r10, qword [rbp-168]
          xor       rax, rax
          cmp       r10, 1000
          setl      al
          mov       qword [rbp-176], rax
          cmp       qword [rbp-176], 0
          jnz       Lab_29
          jmp       Lab_31
Lab_29:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-184], r10
          mov       rdi, qword [rbp-184]
          call      toString_func
          mov       qword [rbp-192], rax
          mov       rdi, qword [rbp-192]
          mov       rsi, const_1_cs
          call      _string_add_func
          mov       qword [rbp-200], rax
          mov       r10, qword [rbp-8]
          mov       qword [rbp-208], r10
          mov       rdi, qword [rbp-208]
          call      get_func
          mov       qword [rbp-216], rax
          mov       rdi, qword [rbp-216]
          call      toString_func
          mov       qword [rbp-224], rax
          mov       rdi, qword [rbp-200]
          mov       rsi, qword [rbp-224]
          call      _string_add_func
          mov       qword [rbp-232], rax
          mov       rdi, qword [rbp-232]
          call      println_func
          jmp       Lab_30
Lab_30:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-240], r10
          mov       r10, qword [rbp-240]
          add       r10, 1
          mov       qword [rbp-248], r10
          mov       r10, qword [rbp-248]
          mov       qword [rbp-8], r10
          jmp       Lab_28
Lab_31:
          mov       rax, 0
          leave     
          ret       
          leave     
          ret       


section .data
const_1_cs:
          db        32,0     ; 
const_2_cs:
          db        117,108,0     ;ul
const_3_cs:
          db        63,63,63,0     ;???
section .bss
@hashsize_var:
          resb      8
@table_var:
          resb      8
